<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="container" id="content">
    <div class="row">
        <div class="col-md-12">
           <#include "parts/search.ftl">
            <div class="row">
                <div class="col-12 mb-3">
                    <div class="card-columns">
                        <#list products as product>
                            <div class="card mb-4">
                                <img class="card-img-top" src="/img/${product.imageUrl?if_exists}"
                                     alt="${product.name?html}">
                                <div class="card-body">
                                    <a href="/product/${product.id}"><h5 class="card-title">${product.name?html}</h5>
                                    </a>
                                    <p class="card-text">${product.description?html}</p>
                                        <#if product.getPrice()<product.getRedemptionPrice()>
                                        <a href="javascript:void(0);" onclick="ajaxBuyOne(${product.getId()});"
                                           class="btn btn-primary">Купить сразу</a>
                                            <h4 class="text-info">${product.redemptionPrice} Р</h4>
                                        </#if>

                                    <a href="javascript:void(0);" onclick="ajaxBuy(${product.getId()});"
                                       class="btn btn-primary">Купить за стоимость + 10%</a>
                                </div>
                                <div class="card-footer">
                                    ${product.getPrice()} Р
                                </div>
                                <div class="card-footer">
                                    <h4 class="text-info">@${product.owner.getUsername()?html}</h4>
                                </div>
                            </div>

                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <@c.footer/>
</@c.page>




