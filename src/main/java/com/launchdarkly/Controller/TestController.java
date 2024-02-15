package com.launchdarkly.Controller;

import com.launchdarkly.common.FlagProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TestController {
    @Autowired
    public FlagProvider flagProvider;
    String TEST_FLAG = "test-flag";

    @GetMapping("/api/test")
    public Boolean testFlag() {
        Boolean featureEnable = flagProvider.isFeatureEnable(TEST_FLAG);
        return featureEnable;
    }

    @GetMapping("/api/test1")
    public Boolean getCountryFlag(@RequestParam("country") String country) {
        Boolean featureEnable = flagProvider.isFeatureEnable(TEST_FLAG, country);
        return featureEnable;
    }
}
