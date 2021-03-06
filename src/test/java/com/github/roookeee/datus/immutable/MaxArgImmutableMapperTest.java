package com.github.roookeee.datus.immutable;

import com.github.roookeee.datus.api.Datus;
import com.github.roookeee.datus.api.Mapper;
import com.github.roookeee.datus.testutil.DetailedPerson;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxArgImmutableMapperTest {


    @Test
    public void basicCopyingShouldWorkCorrectly() {
        //given
        //why o why java-type inference, why do you hate me so much
        Mapper<DetailedPerson, DetailedPerson> mapper = Datus.forTypes(DetailedPerson.class, DetailedPerson.class)
                .immutable(DetailedPerson::new)
                .from(DetailedPerson::getUniqueId).to(ConstructorParameter::bind)
                .from(DetailedPerson::getSalutation).to(ConstructorParameter::bind)
                .from(DetailedPerson::getFirstName).to(ConstructorParameter::bind)
                .from(DetailedPerson::getLastName).to(ConstructorParameter::bind)
                .from(DetailedPerson::getAddress).to(ConstructorParameter::bind)
                .from(DetailedPerson::getAddressExtra).to(ConstructorParameter::bind)
                .from(DetailedPerson::getCity).to(ConstructorParameter::bind)
                .from(DetailedPerson::getOccupation).to(ConstructorParameter::bind)
                .from(DetailedPerson::getCountry).to(ConstructorParameter::bind)
                .from(DetailedPerson::getZipCode).to(ConstructorParameter::bind)
                .from(DetailedPerson::isActive).to(ConstructorParameter::bind)
                .from(DetailedPerson::isAllowedToLogin).to(ConstructorParameter::bind)
                .build();

        DetailedPerson source = new DetailedPerson(
                "uniqueId",
                "salutation",
                "firstName",
                "lastName",
                "address",
                "addressExtra",
                "city",
                "occupation",
                "country",
                "zipCode",
                false,
                false
        );

        //when
        DetailedPerson result = mapper.convert(source);

        //then
        assertThat(result.getUniqueId()).isEqualTo("uniqueId");
        assertThat(result.getSalutation()).isEqualTo("salutation");
        assertThat(result.getFirstName()).isEqualTo("firstName");
        assertThat(result.getLastName()).isEqualTo("lastName");
        assertThat(result.getAddress()).isEqualTo("address");
        assertThat(result.getAddressExtra()).isEqualTo("addressExtra");
        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getOccupation()).isEqualTo("occupation");
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getZipCode()).isEqualTo("zipCode");
        assertThat(result.isActive()).isEqualTo(false);
        assertThat(result.isAllowedToLogin()).isEqualTo(false);
    }

    @Test
    public void simpleUsageShouldWorkCorrectly() {
        //given
        Mapper<Object, DetailedPerson> mapper = Datus.forTypes(Object.class, DetailedPerson.class)
                .immutable(DetailedPerson::new)
                .from(Function.identity()).map(o -> "0").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "1").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "2").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "3").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "4").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "5").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "6").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "7").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "8").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> "9").to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> true).to(ConstructorParameter::bind)
                .from(Function.identity()).map(o -> false).to(ConstructorParameter::bind)
                .build();

        //when
        DetailedPerson result = mapper.convert(new Object());

        //then
        assertThat(result.getUniqueId()).isEqualTo("0");
        assertThat(result.getSalutation()).isEqualTo("1");
        assertThat(result.getFirstName()).isEqualTo("2");
        assertThat(result.getLastName()).isEqualTo("3");
        assertThat(result.getAddress()).isEqualTo("4");
        assertThat(result.getAddressExtra()).isEqualTo("5");
        assertThat(result.getCity()).isEqualTo("6");
        assertThat(result.getOccupation()).isEqualTo("7");
        assertThat(result.getCountry()).isEqualTo("8");
        assertThat(result.getZipCode()).isEqualTo("9");
        assertThat(result.isActive()).isEqualTo(true);
        assertThat(result.isAllowedToLogin()).isEqualTo(false);
    }

    @Test
    public void logicfulUsageShouldWorkCorrectly() {
        //given
        //why o why java-type inference, why do you hate me so much
        Mapper<DetailedPerson, DetailedPerson> mapper = Datus.forTypes(DetailedPerson.class, DetailedPerson.class)
                .immutable(DetailedPerson::new)
                .from(DetailedPerson::getUniqueId).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getSalutation).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getFirstName).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getLastName).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getAddress).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getAddressExtra).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getCity).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getOccupation).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getCountry).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::getZipCode).map(this::appendExclamationMark).to(ConstructorParameter::bind)
                .from(DetailedPerson::isActive).to(ConstructorParameter::bind)
                .from(DetailedPerson::isAllowedToLogin).to(ConstructorParameter::bind)
                .build();

        DetailedPerson source = new DetailedPerson(
                "uniqueId",
                "salutation",
                "firstName",
                "lastName",
                "address",
                "addressExtra",
                "city",
                "occupation",
                "country",
                "zipCode",
                true,
                true
        );

        //when
        DetailedPerson result = mapper.convert(source);

        //then
        assertThat(result.getUniqueId()).isEqualTo("uniqueId!");
        assertThat(result.getSalutation()).isEqualTo("salutation!");
        assertThat(result.getFirstName()).isEqualTo("firstName!");
        assertThat(result.getLastName()).isEqualTo("lastName!");
        assertThat(result.getAddress()).isEqualTo("address!");
        assertThat(result.getAddressExtra()).isEqualTo("addressExtra!");
        assertThat(result.getCity()).isEqualTo("city!");
        assertThat(result.getOccupation()).isEqualTo("occupation!");
        assertThat(result.getCountry()).isEqualTo("country!");
        assertThat(result.getZipCode()).isEqualTo("zipCode!");
        assertThat(result.isActive()).isEqualTo(true);
        assertThat(result.isAllowedToLogin()).isEqualTo(true);
    }

    private String appendExclamationMark(String input) {
        return input + "!";
    }

}
