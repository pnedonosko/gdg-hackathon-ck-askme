package ua.org.gdg.cherkasy.hackathon.askme

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Key

@Entity(unindexed=false)
class Answer {
	String aid
	String qid
	String text
	String lang
}
