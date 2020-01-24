package me.whiteship.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// MOCK MVC 사용방법
/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))      // url 접속
                .andExpect(status().isOk())             // url 접속 상태가 200 인지 체크
                .andExpect(content().string("hellojjunpro"))                   // url content 정보가 작성한 정보와 맞는지 확인
                .andDo(print());
    }
}*/

// TestRestTemplate 사용방법
/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        String result = testRestTemplate.getForObject(
                "/hello",
                String.class
        );
        // url 작성 후 원하는 Body 타입을 적어주면 결과값이 나옵니다.

        assertThat(result).isEqualTo("helloMockJJunpro");
    }
}*/

// WebTestClient 사용방법
/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("helloMockJJunpro");
    }
}*/

// 슬라이스 테스트 (컨트롤만)
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Rule
    public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("helloMockJJunpro"));

        assertThat(outputCaptureRule.toString()).contains("holoman")
                .contains("skip");
    }
}