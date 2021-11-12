package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {


    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @RequestParam age : Int
    ): String {
        println(_name)
        println(age)
        return "$_name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable name: String,
                          @PathVariable(name = "age") _age: Int): String {
        println(name)
        println(_age)
        return "$name $_age"
    }
}