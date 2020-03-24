package com.iam.tugasbm.controller.restapi;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iam.tugasbm.model.dto.BiodataDto;
import com.iam.tugasbm.model.entity.Biodata;
import com.iam.tugasbm.repository.BiodataRepository;

@RestController
@RequestMapping("api/biodata")
public class ApiBiodata {

	@Autowired
	private BiodataRepository biodataRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping()
    public List<BiodataDto> getListBiodata() {
        List<Biodata> biodataList = biodataRepository.findAll();
        List<BiodataDto> biodataDtos =
                biodataList.stream()
                        .map(biodata -> setBiodataDto(biodata))
                        .collect(Collectors.toList());
        return biodataDtos;
    }
	
	private BiodataDto setBiodataDto(Biodata biodata) {
		BiodataDto bd = modelMapper.map(biodata, BiodataDto.class);
		if(biodata.getDetailBiodata()!=null) {
			modelMapper.map(biodata.getDetailBiodata(), bd);
		}
				
		return bd;
	}
	
	@GetMapping("/{idAja}")
	public BiodataDto getBiodata(@PathVariable Integer idAja) {
		Biodata biodata = biodataRepository.findById(idAja).get();
		BiodataDto biodataDto = new BiodataDto();
		biodataDto.setId(biodata.getId());
		biodataDto.setFullName(biodata.getFullName());
		biodataDto.setEmailAddress(biodata.getEmailAddress());
		biodataDto.setAddress(biodata.getAddress());
		biodataDto.setNmDati2(biodata.getDetailBiodata().getNmDati2());
		
		
		return biodataDto;
	}
	
	@PostMapping
    public Biodata editSaveBiodata(@RequestBody Biodata biodata) {
        biodataRepository.save(biodata);
        return biodata;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        biodataRepository.deleteById(Integer.parseInt(id));
    }
	
	
	
}
