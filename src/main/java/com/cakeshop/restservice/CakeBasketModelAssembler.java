package com.cakeshop.restservice;

import com.cakeshop.entities.CakeBasket;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CakeBasketModelAssembler implements RepresentationModelAssembler<CakeBasket, EntityModel<CakeBasket>> {

        @Override
        public EntityModel<CakeBasket> toModel(CakeBasket cakeBasket) {

            // Unconditional links to single-item resource and aggregate root

            EntityModel<CakeBasket> cakeBasketModel = new EntityModel<>(cakeBasket,
                    linkTo(methodOn(CakeBasketController.class).one(cakeBasket.getId())).withSelfRel(),
                    linkTo(methodOn(CakeBasketController.class).all()).withRel("cakeBaskets")
            );

            // Conditional links based on state of the cakeBasket


//                cakeBasketModel.add(
//                        linkTo(methodOn(CakeBasketController.class)
//                                .cancel(cakeBasket.getId())).withRel("cancel"));
//                cakeBasketModel.add(
//                        linkTo(methodOn(CakeBasketController.class)
//                                .complete(cakeBasket.getId())).withRel("complete"));

            return cakeBasketModel;
        }
}
