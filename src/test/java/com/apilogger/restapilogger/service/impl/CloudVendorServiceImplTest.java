package com.apilogger.restapilogger.service.impl;

import com.apilogger.restapilogger.model.CloudVendor;
import com.apilogger.restapilogger.repository.CloudVendorRepository;
import com.apilogger.restapilogger.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1", "Amazon",
            "USA","xxxxxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {

        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
         mock(CloudVendor.class);
         mock(CloudVendorRepository.class);

         when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
         assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Successfully Saved");


    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Updated Successfully");
    }

    @Test
    void testDeleteCloudVendor() {

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).
                isEqualTo("Deleted cloud Vendor 1 Successfully");

    }

    @Test
    void testGetCloudVendor() {

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").
                getVendorName()).isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void testGetByVendorName(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
    }
    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(cloudVendor.getVendorPhoneNumber());

    }
}