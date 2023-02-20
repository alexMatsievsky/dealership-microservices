package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dealership/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService;
}
