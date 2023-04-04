package com.qaprosoft.carina.demo.api.practice;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/products/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/product/_create/rq.json")
@ResponseTemplatePath(path = "api/product/_create/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
@Header(key = "Content-Type", value = "application/json")

public class PostProductMethod extends AbstractApiMethodV2 {

    public PostProductMethod(){
        super("api/product/_create/rq.json", "api/product/_create/rs.json", "api/product/product.properties");
        replaceUrlPlaceholder("base_url", "https://dummyjson.com");
    }
}
