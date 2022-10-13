package me.raylleremery.springvalidationsexample

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SpringvalidationsexampleApplicationTests {

	@Test
	fun contextLoads() {

		val date = LocalDate.now()
		val format = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		val dateFormatted = format.format(date)
		println(date)
		println(dateFormatted)
	}

}
