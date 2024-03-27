package es.yan.mipymes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/mipymes")
public class MipymesController {

	@Autowired
	private MipymesService mipymeService;

	@PostMapping("/createMipymes")
	public Mipymes createMipymes(@RequestBody Mipymes mipyme) {
		return mipymeService.createMipymes(mipyme);
	}

	@GetMapping("/id")
	public Mipymes getMipymeById(@RequestParam Long id) {
		return mipymeService.getMipymesById(id);
	}

	@GetMapping("/getAllMipymes")
	public List<Mipymes> getAllMipymes() {
		return mipymeService.getAllMipymes();
	}

	@PostMapping("/enableOrUnableMipymeById")
	public Mipymes enableOrUnableMipymeById(@RequestParam long id, @RequestParam boolean enable) {
		return mipymeService.enableOrUnableMipymeById(id, enable);
	}

}
