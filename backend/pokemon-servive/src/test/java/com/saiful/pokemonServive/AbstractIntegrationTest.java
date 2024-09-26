/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive;

import org.mockserver.client.MockServerClient;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

public abstract class AbstractIntegrationTest {
    protected static MockServerClient mockServerClient;

    static MockServerContainer mockServerContainer = new MockServerContainer(
            DockerImageName.parse("mockserver/mockserver:5.15.0")
    );



    @DynamicPropertySource
    static void setupContainers(DynamicPropertyRegistry registry){
        Startables.deepStart(mockServerContainer).join();
        registry.add("api.path", mockServerContainer::getEndpoint);
        mockServerClient = new MockServerClient(mockServerContainer.getHost(), mockServerContainer.getServerPort());

    }
}
