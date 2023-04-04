package com.qaprosoft.carina.demo.practice;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.practice.DeleteProductMethods;
import com.qaprosoft.carina.demo.api.practice.GetProductMethods;
import com.qaprosoft.carina.demo.api.practice.PostProductMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateProduct() throws Exception {
        PostProductMethod api = new PostProductMethod();
        api.setProperties("api/product/product.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetProduct() {
        GetProductMethods getProductMethods = new GetProductMethods();
        getProductMethods.callAPIExpectSuccess();
        getProductMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getProductMethods.validateResponseAgainstSchema("api/product/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteProducts() {
        DeleteProductMethods deleteProductMethod = new DeleteProductMethods();
        //deleteProductMethod.setProperties("api/product/product.properties");
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse();
    }
}
