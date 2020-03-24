package com.iam.tugasbm.controller.restapi;

import com.iam.tugasbm.model.entity.DetailBiodata;
import com.iam.tugasbm.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/detail")
public class ApiDetail {
	
	@Autowired
    private DetailRepository detailRepository;

    @GetMapping
    public List<DetailBiodata> getAll() {

        return detailRepository.findAll();
    }

    @PostMapping
    public DetailBiodata save(@RequestBody DetailBiodata detailBiodata) {

        return detailRepository.save(detailBiodata);
    }

    @GetMapping("/{golonganDarah}")
    public List<DetailBiodata> getByGolonganDarah(@PathVariable String nmDati2) {
        return detailRepository.findAllByNmDati2(nmDati2);
    }
    
}
