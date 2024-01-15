package com.apilogger.restapilogger.service.impl;

import com.apilogger.restapilogger.exception.CloudVendorNotFoundException;
import com.apilogger.restapilogger.model.CloudVendor;
import com.apilogger.restapilogger.repository.CloudVendorRepository;
import com.apilogger.restapilogger.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // More Business logic
        cloudVendorRepository.save(cloudVendor);
        return "Successfully Saved";
    }



    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // More Business logic
        cloudVendorRepository.save(cloudVendor);
        return "Updated Successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // More Business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted cloud Vendor "+cloudVendorId+" Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // More Business logic
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
                throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // More Business logic
        return cloudVendorRepository.findAll();

    }
    @Override
    public List<CloudVendor> getByVendorName(String vendorName){

        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
