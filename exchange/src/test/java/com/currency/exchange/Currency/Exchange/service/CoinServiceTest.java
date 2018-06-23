package com.currency.exchange.Currency.Exchange.service;

import com.currency.exchange.Currency.Exchange.model.Coin;
import com.currency.exchange.Currency.Exchange.repository.CoinRepository;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import com.currency.exchange.Currency.Exchange.service.mapper.CoinMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class CoinServiceTest {


    @InjectMocks
    private CoinService service;

    @Mock
    private CoinMapper mapper;

    @Mock
    private CoinRepository repository;

    private CoinDTO dto;
    private Coin entity;

    @Before
    public void setUp() {
        dto = createDTO(1L);
        entity = createEntity(1L);
        when(mapper.toDto(entity)).thenReturn(dto);
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
    }

    @Test
    @Transactional
    public void save() {
        CoinDTO savedDTO = service.persist(dto);
        assertEquals(dto.getName(), savedDTO.getName());
    }

    @Test
    public void dumb() {
        Map<String, Coin> m = Arrays.asList(1, 2, 3).stream().map(e ->
                new Coin.CoinBuilder("name").setValue(BigDecimal.valueOf(e)).build()
        ).collect(Collectors.toMap(p -> p.getName(), p -> p));
        assertEquals(1, 1);

    }

    private Coin createEntityWithoutId() {
        Coin entity = new Coin();
        entity.setName("myName");
        entity.setValue(BigDecimal.ZERO);
        return entity;
    }

    private Coin createEntity(Long id) {
        Coin entity = createEntityWithoutId();
        entity.setId(id);
        return entity;
    }

    private CoinDTO createDTOWithoutId() {
        CoinDTO dto = new CoinDTO();
        dto.setName("myName");
        return dto;
    }

    private CoinDTO createDTO(Long id) {
        CoinDTO entity = createDTOWithoutId();
        entity.setId(id);
        return entity;
    }


    private List<CoinDTO> createDTOList(int n) {
        return IntStream.range(0, n).mapToObj(i -> createDTO(Long.valueOf(i))).collect(Collectors.toList());
    }

    private List<Coin> createEntityList(int n) {
        return IntStream.range(0, n).mapToObj(i -> createEntity(Long.valueOf(i))).collect(Collectors.toList());
    }


}
