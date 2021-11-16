package com.example.mvc.controller.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController {


    // 1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {
            // age not null
            if (it < 20) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값은 20 보다 커야 합니다.")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            // age is null
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값이 누락 되었습니다.")
        }


        /*
        // 0. age == null -> 400 error
        if (age == null) {
            // return ResponseEntity.badRequest().body("fail")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값이 누락 되었습니다.")
        }

        // 1. age < 20 -> 400 error
        if (age < 20) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값은 20 보다 커야 합니다.")
        }

         */

        // println(age)
        // return ResponseEntity.ok("OK")
    }

    // 2. post 200

    // 3. put 201

    // 4. delete 500

}