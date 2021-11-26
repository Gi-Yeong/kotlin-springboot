package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated  // 해당 어노테이션을 붙이면 Bean 이 아닌 컨트롤러 단에서 검증을 할 때
class DeleteApiController {


    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "age 값은 필수 입니다.")
        @Min(value = 20, message = "20보다 커야 합니다.")
        @RequestParam age: Int
    ): String {
        println(_name)
        println(age)
        return "$_name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name")
        @Size(min = 2, max = 5, message = "name 의 길이는 2 에서 5")
        @NotNull
        _name: String,

        @NotNull(message = "age 값은 필수 입니다.")
        @Min(value = 20, message = "20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }
}