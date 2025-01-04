<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Add Car</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<div class="container mt-5">
    <h1 class="mb-4  fw-bold">Add Car</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="container">
            <div class="row mb-3">
                <div class="col-12">
                    <label for="license_plate" class="form-label fw-bold">License Plate</label>
                    <input type="text" class="form-control" id="license_plate" name="license_plate" required>
                    <div class="invalid-feedback">License Plate is required.</div>
                </div>
                <div class="col-12">
                    <label for="parking_spot" class="form-label fw-bold">Parking Spot</label>
                    <input type="text" class="form-control" id="parking_spot" name="parking_spot" required>
                    <div class="invalid-feedback">Parking Spot is required.</div>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-12">
                    <label for="owner_id" class="form-label fw-bold">Owner</label>
                    <select class="form-select" id="owner_id" name="owner_id" required>
                        <option value="">Choose...</option>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">Please select an owner.</div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </form>
</div>


<script src="/ParkingLot-1.0-SNAPSHOT/scripts/form-validation.js"></script>