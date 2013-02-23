
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/datetime", forward: "/datetime.groovy"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

post "/register", forward: "/register.groovy"

post "/q", forward: "/postQuestion.groovy"

get "/qs", forward: "/getQuestions.groovy"

get "/q/a", forward: "/getAnswers.groovy"

get "/q", forward: "/getQuestion.groovy"


