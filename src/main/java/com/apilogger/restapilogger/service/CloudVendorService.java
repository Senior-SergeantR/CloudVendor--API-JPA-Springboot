package com.apilogger.restapilogger.service;

import com.apilogger.restapilogger.model.CloudVendor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);

    public List<CloudVendor> getAllCloudVendors();

    public List<CloudVendor>getByVendorName(String amazon);
}
