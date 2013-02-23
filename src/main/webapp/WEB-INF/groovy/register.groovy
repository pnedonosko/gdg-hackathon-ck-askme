import ua.org.gdg.cherkasy.hackathon.askme.*

def devId = params.id
def json
if (devId) {
	// TODO store registration
	def user
	def oldDevId = params.oldId
	if (oldDevId) {
		user = User.get(oldDevId)
		if (user) {
			log.info "Update user registration ${devId} ${user.fullName}"
			user.deviceId = devId
			user.firstName = params.firstname
			user.lastName = params.lastname
			user.lang = params.lang
		} else {
			// error, device not registred but oldId provided
			json = jsonLibBuilderFactory.jsonLibBuilder.json { error = "Not registered" }
			response.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST,
					json.toString())
			return
		}
	} else {
		user = User.get(devId)
		if (user) {
			log.info "Update user ${devId} ${user.fullName}"
			user.firstName = params.firstname
			user.lastName = params.lastname
			user.lang = params.lang
		} else {
			log.info "Create user registration ${devId} ${params.firstname} ${params.lastname}"
			user = new User(deviceId : devId,
					firstName : params.firstname, lastName : params.lastname,
					lang : params.lang, description : "")
		}
	}

	user.save()

	// return OK
	json = jsonLibBuilderFactory.jsonLibBuilder.json { id = user.deviceId }
	response.renderJson json
} else {
	json = jsonLibBuilderFactory.jsonLibBuilder.json { error = "Id not set" }
	response.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST,
			json.toString())
}
