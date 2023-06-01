package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
/**
 * 사용할 Properties 지정. 지정된 클래스는 스프링 빈으로 등록되고, 필요한 곳에서 주입 받아서 사용 가능
 * @ConfigurationPropertiesScan 을 사용하면 특정 범위로 자동 등록이 가능하다.
 *
 * @ConfigurationProperties 를 하나하나 직접 등록할 때는 @EnableConfigurationProperties 사용.
 * @EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
 * DataSourceAutoConfiguration.class 에서도 사용
 *
 * @ConfigurationProperties 를 특정 범위로 자동 등록할 때는 @ConfigurationPropertiesScan 사용.
 */
//@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
public class MyDataSourceConfigV1 {
    // 생성자를 통해 주입
    private final MyDataSourcePropertiesV1 properties;

    public MyDataSourceConfigV1(MyDataSourcePropertiesV1 properties) {
        this.properties = properties;
    }

    @Bean
    public MyDataSource dataSource() {
        return new MyDataSource(
                properties.getUrl(),
                properties.getUsername(),
                properties.getPassword(),
                properties.getEtc().getMaxConnection(),
                properties.getEtc().getTimeout(),
                properties.getEtc().getOptions());
    }
}
