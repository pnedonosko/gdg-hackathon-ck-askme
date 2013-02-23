package ua.org.gdg.cherkasy.hackathon.askme

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
class Question {
	@Key String qid
	String text
	String lang
	Date created
	Integer status
}
