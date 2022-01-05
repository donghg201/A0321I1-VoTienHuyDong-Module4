package com.example.casestudy.controller;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.CustomerRepository;
import com.example.casestudy.repository.customer.CustomerTypeRepository;
import com.example.casestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 3) Pageable pageable,
                           Optional<String> key_search
//            ,Optional<Long> topicId
    ) {
//        model.addAttribute("customerList", customerRepository.findAll());
        if (key_search.isPresent()) {
            model.addAttribute("customers", customerService.findAllByName(key_search.get(), pageable));
        } else {
//            if (topicId.isPresent()) {
            model.addAttribute("customers", customerService.findAllCustomer(pageable));
//            }
        }
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeIdList", customerTypeRepository.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeIdList", customerTypeRepository.findAll());
            return "/customer/create";
        } else {
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customerTypeIdList", customerTypeRepository.findAll());
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/delete";
    }

    @PostMapping("/delete-customer/{id}")
    public String deleteCustomer(@ModelAttribute("id") Integer id, @PageableDefault(size = 3) Pageable pageable,
                                 Model model) {
        customerService.deleteCustomerById(id);
        Page<Customer> customerPage = customerService.findAllCustomer(pageable);
        model.addAttribute("customers", customerPage);
        return "customer/searchTable";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/detail";
    }
}
