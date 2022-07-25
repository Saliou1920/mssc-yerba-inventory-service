package io.saliou.msscyerbainventoryservice.web.controllers;

import io.saliou.msscyerbainventoryservice.repositories.YerbaInventoryRepository;
import io.saliou.msscyerbainventoryservice.web.mappers.YerbaInventoryMapper;
import io.saliou.msscyerbainventoryservice.web.model.YerbaInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class YerbaInventoryController {

    private final YerbaInventoryRepository yerbaInventoryRepository;
    private final YerbaInventoryMapper yerbaInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<YerbaInventoryDto> listBeersById(@PathVariable UUID beerId){
        log.debug("Finding Inventory for beerId:" + beerId);

        return yerbaInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(yerbaInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
