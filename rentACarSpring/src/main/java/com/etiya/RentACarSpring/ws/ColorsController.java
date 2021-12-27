package com.etiya.RentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import com.etiya.RentACarSpring.business.abstracts.ColorService;
import com.etiya.RentACarSpring.business.dtos.ColorDto;
import com.etiya.RentACarSpring.business.requests.color.CreateColorRequest;
import com.etiya.RentACarSpring.business.requests.color.DeleteColorRequest;
import com.etiya.RentACarSpring.business.requests.color.UpdateColorRequest;
import com.etiya.RentACarSpring.core.results.DataResult;
import com.etiya.RentACarSpring.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping("/getall")
	public DataResult<List<ColorDto>> getAll() {
		return this.colorService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<ColorDto> getById(int colorId) {
		return this.colorService.getById(colorId);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.add(createColorRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}

}
