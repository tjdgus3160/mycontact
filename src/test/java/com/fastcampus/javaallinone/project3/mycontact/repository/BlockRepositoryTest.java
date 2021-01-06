package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTest {

    @Autowired
    BlockRepository blockRepository;

    @Test
    void curd(){
        Block block = new Block();
        block.setName("martin");
        block.setReason("친하지않아서");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now().plusDays(3));

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();

        assertEquals(blocks.size(),3);
        assertEquals(blocks.get(0).getName(),"dennis");
        assertEquals(blocks.get(1).getName(),"sophia");
        assertEquals(blocks.get(2).getName(),"martin");
    }
}