package com.quantdev.lab1.service.impl;

import com.quantdev.lab1.mapper.CounterMapper;
import com.quantdev.lab1.service.CounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterServiceImpl implements CounterService {
    private final CounterMapper counterMapper;

    public CounterServiceImpl(CounterMapper counterMapper) {
        this.counterMapper = counterMapper;
    }

    @Override
    public int getCount() {
        Integer count = counterMapper.selectCount();
        return count == null ? 0 : count;
    }

    @Override
    @Transactional
    public int incrementAndGetCount() {
        counterMapper.incrementCount();
        Integer count = counterMapper.selectCount();
        return count == null ? 0 : count;
    }
}
