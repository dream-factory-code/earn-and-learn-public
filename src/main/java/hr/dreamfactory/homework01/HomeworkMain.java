package hr.dreamfactory.homework01;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;
import hr.dreamfactory.homework01.api.RandomUserAPI;
import hr.dreamfactory.homework01.model.UserModel;
import hr.dreamfactory.homework01.model.UsersModels;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HomeworkMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkMain.class);


    public static void main(String[] args) {
        RandomUserAPI api = Feign.builder()
                .contract(new JAXRSContract())
                .decoder(new GsonDecoder())
                .target(RandomUserAPI.class, "https://randomuser.me/");
        UsersModels result = api.getUsers("10");



//        System.out.println(result.getRandomUsers());
//        if(result == null) {
//            System.out.println("NEŠTOOOOOOOO");
//        }
//        System.out.println(result);


        for (UserModel u : result.getResults()) {
            System.out.println(u);
        }

//        for (User user : result.getRandomUsers()) {
//            LOGGER.info("ime je {}", user.fullname());
//        }
    }
}
