import ua.org.gdg.cherkasy.hackathon.askme.*

def lang = params.lang
def text = params.text
if (text) {
	def qid = System.currentTimeMillis() + '-' + text.hashCode()
	def q = new Question(qid : qid, text : text, lang : lang, created : Calendar.getInstance().getTime(),
			status : 0)
	q.save()
	log.info "Question created $text $lang"
	def json = jsonLibBuilderFactory.jsonLibBuilder.json { qid = qid }
	response.renderJson json
} else {
	def json = jsonLibBuilderFactory.jsonLibBuilder.json { error = "Text expected" }
	response.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST,
			json.toString())
}







