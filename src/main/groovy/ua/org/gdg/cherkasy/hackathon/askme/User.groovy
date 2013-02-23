/**
 * 
 */
package ua.org.gdg.cherkasy.hackathon.askme

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Ignore
import groovyx.gaelyk.datastore.Key
import groovyx.gaelyk.datastore.Unindexed

/**
 * @author peter
 *
 */
@Entity(unindexed=false)
class User {
	@Key String deviceId
	String firstName
	String lastName
	String login
	String lang
	@Unindexed String description
	@Ignore String getFullName() {
		"$firstName $lastName"
	}
}
