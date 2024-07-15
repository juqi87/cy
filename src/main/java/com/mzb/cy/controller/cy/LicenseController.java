package com.mzb.cy.controller.cy;

import com.mzb.cy.service.LicenseManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController {

    @GetMapping("/generateLicense")
    public String generateLicense(@RequestParam String userId, @RequestParam long durationInDays) throws Exception {
        return LicenseManager.generateLicense(userId, durationInDays);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(LicenseManager.generateLicense("juqi", 1L));
    }

}
