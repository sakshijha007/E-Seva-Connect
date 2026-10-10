// Illustrative snippet; complete entity, repository, DTOs, imports, and configuration.
@Service
public class ServiceRequestService {
    private final ServiceRequestRepository repository;

    public ServiceRequestService(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public RequestResponse create(UUID citizenId, CreateRequestDto dto) {
        String reference = "ESV-" + UUID.randomUUID()
                                  .toString().substring(0, 8).toUpperCase();
        ServiceRequest request = new ServiceRequest();
        request.setReferenceNumber(reference);
        request.setCitizenId(citizenId); // derive from authenticated principal
        request.setServiceCategory(dto.serviceCategory().trim());
        request.setTitle(dto.title().trim());
        request.setDescription(dto.description().trim());
        request.setStatus(RequestStatus.SUBMITTED);
        ServiceRequest saved = repository.save(request);
        return new RequestResponse(saved.getReferenceNumber(),
            saved.getStatus().name(), saved.getCreatedAt());
    }
}
