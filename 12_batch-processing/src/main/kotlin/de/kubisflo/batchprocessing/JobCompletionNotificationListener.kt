package de.kubisflo.batchprocessing

import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.function.Consumer

@Component
class JobCompletionNotificationListener : JobExecutionListenerSupport() {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun afterJob(jobExecution: JobExecution) {
        log.warn("afterJob ${jobExecution.status}")

        if (jobExecution.status == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")
            jdbcTemplate.query(
                "SELECT first_name, last_name FROM people"
            ) { rs: ResultSet, _: Int ->
                Person(
                    rs.getString(1),
                    rs.getString(2)
                )
            }.forEach(Consumer { person: Person ->
                log.info("Found <$person> in the database.")
            })
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
    }
}