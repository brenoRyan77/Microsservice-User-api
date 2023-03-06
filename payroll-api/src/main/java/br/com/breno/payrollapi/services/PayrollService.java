package br.com.breno.payrollapi.services;

import br.com.breno.payrollapi.domain.Payroll;
import br.com.breno.payrollapi.feignClients.UserFeign;
import br.com.breno.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollService {

    private final Environment envi;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on "
                + envi.getProperty("local.server.port") + " port" );

        try{
            var user = feign.findById(workerId).getBody();

            if(Objects.nonNull(user)){
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }

        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }

        return null;
    }
}
