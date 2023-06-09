package com.qaprosoft.carina.demo.api.practice;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/products", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/product/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetProductMethods extends AbstractApiMethodV2 {

    public GetProductMethods() {
        replaceUrlPlaceholder("base_url", "https://dummyjson.com");
    }
}
