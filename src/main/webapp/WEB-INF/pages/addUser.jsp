<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Add User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<div class="container mt-5">
    <h1 class="mb-4  fw-bold">Username</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="container">
            <div class="row mb-3">
                <div class="col-12">
                    <label for="username" class="form-label fw-bold">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                    <div class="invalid-feedback">Username is required.</div>
                </div>
                <div class="col-12">
                    <label for="email" >Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="" value="" required>
                    <div class="invalid-feedback">Email is required.</div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="password">Password</label>
                    <input type="password" class="from-control" id="password" name="password" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Password is required.
                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-12">
                    <label for="user_groups">Groups</label>
                    <select class="custom-select d-block w-100" id="user_groups" name="user_groups" multiple>

                        <c:forEach var="user_group" items="${userGroups}" varStatus="status">
                            <option value="${user_group}">${user_group}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
                    <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>
</div>


<script src="/ParkingLot-1.0-SNAPSHOT/scripts/form-validation.js"></script>