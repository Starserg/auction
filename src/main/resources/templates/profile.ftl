<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/adminnav.ftl">
<!--Сontent-->
<div class="container-fluid" id="content">
    <div class="row justify-content-center">
        <div class="col-12 col-md-6 col-xl-3">
            <div class="mt-3">
                <form method="post" action="/user/profile/changefirstname">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon-firstName">Имя</span>
                        </div>
                        <input maxlength="50" minlength="1" name="firstName" value="${firstName}" type="text"
                               class="form-control" placeholder="Имя"
                               aria-describedby="basic-addon-firstName">
                        <div class="input-group-append">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-outline-primary" value="save">
                        </div>
                    </div>
                </form>
            </div>
            <div class="mt-3">
                <form method="post" action="/user/profile/changesecondname">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon-secondName">Фамилия</span>
                        </div>
                        <input maxlength="50" name="secondName" value="${secondName}" type="text" class="form-control"
                               placeholder="Имя" aria-describedby="basic-addon-secondName">
                        <div class="input-group-append">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-outline-primary" value="save">
                        </div>
                    </div>
                </form>
            </div>
    </div>

</div>
    <@c.footer/>
</@c.page>