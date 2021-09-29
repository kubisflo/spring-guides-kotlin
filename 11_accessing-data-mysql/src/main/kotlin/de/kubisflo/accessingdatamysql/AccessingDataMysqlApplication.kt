package de.kubisflo.accessingdatamysql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository

@SpringBootApplication
class AccessingDataMysqlApplication

fun main(args: Array<String>) {
	runApplication<AccessingDataMysqlApplication>(*args)
}

data class User(
	@Id
	val id: Int,
	val name: String,
	val email: String
)

interface UserRepository : CrudRepository<User, Int>
