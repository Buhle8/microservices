/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.43).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package za.co.protogen.controller.api;

import za.co.protogen.controller.models.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-07T19:37:13.244825700Z[Europe/London]")
@Validated
public interface ReservationsApi {

    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Reservation added successfully") })
    @RequestMapping(value = "/reservations",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addReservation(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ReservationDto body);


    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservations returned successfully", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ReservationDto.class)))) })
    @RequestMapping(value = "/reservations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ReservationDto>> getAllReservations();


    @Operation(summary = "Return a reservation by id", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservation returned successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReservationDto.class))),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ReservationDto> getReservationById(@Parameter(in = ParameterIn.PATH, description = "id of a reservation to be returned", required=true, schema=@Schema()) @PathVariable("id") BigDecimal id);


    @Operation(summary = "Remove a Reservation by id", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Reservation removed successfully"),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> removeReservation(@Parameter(in = ParameterIn.PATH, description = "id of a reservation to be removed", required=true, schema=@Schema()) @PathVariable("id") BigDecimal id);


    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservations returned successfully", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ReservationDto.class)))),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/searchReservations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ReservationDto>> searchReservations(@Parameter(in = ParameterIn.QUERY, description = "Id of the reservation to be fetched" ,schema=@Schema()) @Valid @RequestParam(value = "id", required = false) BigDecimal id, @Parameter(in = ParameterIn.QUERY, description = "user Id of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "userId", required = false) BigDecimal userId, @Parameter(in = ParameterIn.QUERY, description = "car Id of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "carId", required = false) BigDecimal carId, @Parameter(in = ParameterIn.QUERY, description = "from date of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "fromDate", required = false) LocalDate fromDate, @Parameter(in = ParameterIn.QUERY, description = "to date of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "toDate", required = false) LocalDate toDate, @Parameter(in = ParameterIn.QUERY, description = "pick up location of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "pickUpLocation", required = false) String pickUpLocation, @Parameter(in = ParameterIn.QUERY, description = "drop off location of a reservation to be searched" ,schema=@Schema()) @Valid @RequestParam(value = "dropoffLocation", required = false) String dropoffLocation);


    @Operation(summary = "update a reservation identified by id", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservation updated successfully"),
        
        @ApiResponse(responseCode = "404", description = "Reservation not found") })
    @RequestMapping(value = "/reservations/{id}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateReservation(@Parameter(in = ParameterIn.PATH, description = "id of a reservation to be updated", required=true, schema=@Schema()) @PathVariable("id") BigDecimal id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ReservationDto body);

}

