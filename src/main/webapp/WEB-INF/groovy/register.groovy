def devId = params.id
def json
if (devId) {

	// TODO store registration
	log.info "Registration $devId"

	
	
	// return OK
	json = jsonLibBuilderFactory.jsonLibBuilder.json { id = devId }

	response.renderJson json
} else {
	json = jsonLibBuilderFactory.jsonLibBuilder.json { error = "Id not set" }
	response.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST,
			json.toString())
}
