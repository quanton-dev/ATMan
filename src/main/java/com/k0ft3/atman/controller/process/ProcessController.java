package com.k0ft3.atman.controller.process;

import com.k0ft3.atman.repository.ProcessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("process")
@Data
@AllArgsConstructor
public class ProcessController {
    @Autowired
    private ProcessRepository processRepository;
}