package principal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import principal.model.Imovel;

@ExtendWith(MockitoExtension.class)
//@DisplayName("airbnb service")
class ImovelServiceTest {


	@Mock
	private ImovelService service;
	
	Imovel imovel =  new Imovel();
	
	@BeforeEach
	void initMock() {
		
	
		
	 imovel = new Imovel(false, 2, 2, 4, "Casa de Praia",
				"https://a0.muscache.com/im/pictures/283182b1-33ad-4f50-b8a5-923a1b77b4b3.jpg?im_w=960", 100.5,
				5185452158l, "91111000", "Porto Alegre", "Rio Branco", "RS", "Ijui", 255, "ap 201");		 
			 
			 
			 
	}

	// @DisplayName("airbnb service")
	@Test
	void testBuscarPorId() {
		Long num = 1l;
		Optional<Imovel> imovelOpt = Optional.of(imovel);
		when(service.buscarPorId(num)).thenReturn(imovelOpt);

		assertEquals(imovelOpt, service.buscarPorId(num));

	}
	
	
	
	

}

//package br.com.startDB.airbnbclone.service;
//import br.com.startDB.airbnbclone.model.Guest;
//import br.com.startDB.airbnbclone.model.Host;
//import br.com.startDB.airbnbclone.repository.GuestRepository;
//import br.com.startDB.airbnbclone.repository.HostRepository;
//import br.com.startDB.airbnbclone.repository.ReserveRepository;
//import br.com.startDB.airbnbclone.repository.RoomRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//@ExtendWith(MockitoExtension.class)
//@DisplayName("airbnb service")
//class AirbnbServiceImplTest {
//   
//   @Mock
//   private GuestRepository guestRepository;
//   
//   @Mock
//   private HostRepository hostRepository;
//   
//   @Mock
//   private RoomRepository roomRepository;
//   
//   @Mock
//   private ReserveRepository reserveRepository;
//   
//   @InjectMocks
//   private AirbnbServiceImpl airbnbService;
//   
//   @Test
//   @DisplayName("should find a host by email")
//   public void shouldFindByEmail() {
//      String hostEmail = "email@host.com.br";
//      
//      Host host = new Host(hostEmail, "123", "Maurício", "Silva", "123456789");
//      
//      when(hostRepository.findHostByEmailIgnoreCase(hostEmail))
//            .thenReturn(host);
//      
//      assertEquals(host, airbnbService.findHostByEmailIgnoreCase(hostEmail));
//   }
//   
//   @Test
//   public void shouldDelete() {
//      Guest guestToBeDeleted = new Guest();
//      guestToBeDeleted.setName("João");
//      
//      airbnbService.deleteGuest(guestToBeDeleted);
//      verify(guestRepository, times(1)).delete(guestToBeDeleted);
//   }
//   
//}
