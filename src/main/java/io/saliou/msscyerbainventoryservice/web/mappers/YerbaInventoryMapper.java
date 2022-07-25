package io.saliou.msscyerbainventoryservice.web.mappers;

import io.saliou.msscyerbainventoryservice.domain.YerbaInventory;
import io.saliou.msscyerbainventoryservice.web.model.YerbaInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface YerbaInventoryMapper {

    YerbaInventory beerInventoryDtoToBeerInventory(YerbaInventoryDto yerbaInventoryDTO);

    YerbaInventoryDto beerInventoryToBeerInventoryDto(YerbaInventory yerbaInventory);
}
