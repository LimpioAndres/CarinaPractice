package com.qaprosoft.carina.demo.api.practice;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/products/1", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/product/_delete/rq.json")
@ResponseTemplatePath(path = "api/product/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class DeleteProductMethods extends AbstractApiMethodV2 {

    public DeleteProductMethods(){
        replaceUrlPlaceholder("base_url", "https://dummyjson.com");
    }
}
