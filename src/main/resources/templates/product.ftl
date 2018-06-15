<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
 <!--Сontent-->
        <div class="container" id="content">
            <div class="row">
                <div class="col-md- bg-light text-dark">
                    <#include "parts/search.ftl">

                    <#if isAdmin>
                        <#include "parts/productedit.ftl">
                    </#if>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="">
                                <img src="/img/${product.imageUrl?if_exists}" class="img-fluid">
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="row">
                                <div class="col"><h3>${product.name?html}</h3></div>
                            </div>
                            <div class="row">
                                <div class="col"><h3>@${product.owner.username?html}</h3></div>
                            </div>
                            <#if product.getPrice()<product.getRedemptionPrice()>
                            <div class="row">
                                <div class="col"><h5 class="text-primary">${product.redemptionPrice} Р</h5></div>
                            </div>
                            <div class="row">
                                <a href="javascript:void(0);" onclick="ajaxBuyOne(${product.getId()});"
                                   class="btn btn-primary">Купить</a>
                            </div>
                            </#if>
                            <div class="row">
                                <div class="col"><h5 class="text-primary">${product.price} Р</h5></div>
                            </div>
                            <div class="row">
                                <a href="javascript:void(0);" onclick="ajaxBuy(${product.getId()});"
                                   class="btn btn-primary">Купить стоимость + 10%</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col"><h5>Описание товара</h5>
                                <p>${product.description?html}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <@c.footer/>
</@c.page>
