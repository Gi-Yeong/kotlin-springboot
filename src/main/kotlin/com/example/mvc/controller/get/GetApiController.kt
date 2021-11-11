package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {


    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin mapping"
    }

    @RequestMapping(path = ["request-mapping"], method = [RequestMethod.GET])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable(value = "name") name: String,
                     @PathVariable age: Int): String{
        println("$name, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable("name") _name: String,
                      @PathVariable(name = "age") age: Int): String{

        val name = "kotlin"

        println("$_name, $age")
        return "$_name $age"
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(@RequestParam name: String,
                   @RequestParam(value = "age") age: Int): String {

        println("$name, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {

        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)

        val phoneNumber = map["phone-number"]
        println(phoneNumber)

        return map
    }

}