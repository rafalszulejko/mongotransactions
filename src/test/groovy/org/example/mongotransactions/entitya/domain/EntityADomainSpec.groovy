package org.example.mongotransactions.entitya.domain

import org.example.mongotransactions.MongoDBContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@Testcontainers
@DataMongoTest
@ContextConfiguration(classes = [MongoDBContainerTestConfiguration.class])
class EntityADomainSpec extends Specification {

	@Autowired EntityAMongoRepository simulationRepository
	@Autowired EntityBMongoRepository plotRepository

	EntityDomainService service

	def setup() {
		service = new EntityDomainConfiguration().domainService(simulationRepository, plotRepository)
	}

	def cleanup() {
		simulationRepository.deleteAll()
		plotRepository.deleteAll()
	}

	def "simulation should be registered"() {
		when:
		EntityA registered = service.register(EntityA.builder().id("abc").build())

		then:
		service.get(registered.getId()).getId() == registered.getId()
	}

	def "basic transaction test"() {
		when:
		service.transactionalAdd("abc", "def")

		then:
		thrown(RuntimeException)
		!simulationRepository.existsById("abc")
	}
}
