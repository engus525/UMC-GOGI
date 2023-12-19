package com.example.umcstudy.web.controller;

import com.example.umcstudy.converter.TempConverter;
import com.example.umcstudy.payload.ApiResponse;
import com.example.umcstudy.service.TempQueryService;
import com.example.umcstudy.web.dto.TempResponse;
import com.example.umcstudy.web.dto.TempResponse.TempExceptionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testPage() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/v1/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionPageV1(@RequestParam Integer flag) {
        tempQueryService.checkFlag(flag);
        TempExceptionDTO tempExceptionDTO = TempConverter.toTempExceptionDTO(flag);
        System.out.println("tempExceptionDTO.toString() = " + tempExceptionDTO.toString());
        return ApiResponse.onSuccess(tempExceptionDTO);
    }
    @GetMapping("/v2/exception")
    public ResponseEntity<TempExceptionDTO> exceptionPageV2(@RequestParam Integer flag) {
        tempQueryService.checkFlag(flag);
        TempExceptionDTO tempExceptionDTO = TempConverter.toTempExceptionDTO(flag);
        return ResponseEntity.ok(tempExceptionDTO);
    }

}
