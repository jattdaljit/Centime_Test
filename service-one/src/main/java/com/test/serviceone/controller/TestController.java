package com.test.serviceone.controller;

import com.test.serviceone.dto.ResponseDTO;
import com.test.serviceone.dto.User;
import com.test.serviceone.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service-one")
@Api(value = "test controller for service one")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    @ApiOperation(value = "Get application status", response = ResponseDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully got response")})
    public ResponseDTO getStatus() {
        return getResponseDTO(testService.getStatus());
    }

    @PostMapping
    @ApiOperation(value = "Get concatenated response from service two and service three", response = ResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully got response"),
            @ApiResponse(code = 500, message = "Internal Server error")
    })
    public ResponseDTO getConcatResponse(@RequestBody User user) {
        return getResponseDTO(testService.getResponse(user));
    }

    private ResponseDTO getResponseDTO(String response) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse(response);
        return responseDTO;
    }
}
