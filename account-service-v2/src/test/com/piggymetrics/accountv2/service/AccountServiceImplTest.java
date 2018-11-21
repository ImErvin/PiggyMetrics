package com.piggymetrics.accountv2.service;

import com.piggymetrics.accountv2.repository.AccountDBProvider;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;

public class AccountServiceImplTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountDBProvider repository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

    }
}