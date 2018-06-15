<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="container" id="content">
    <div class="row">
        <div class="col-md-12">
           <#include "parts/search.ftl">
            <div class="row">
                <div class="col-12 mb-3">
                        <#list products as product>
                            <#if ((product?counter-1)%4)==0>
                                <div class="card-columns">
                            </#if>
                            <div class="card mb-4">
                                <img class="card-img-top" src="/img/${product.imageUrl?if_exists}"
                                     alt="${product.name}">
                                <div class="card-body">
                                    <a href="/product/${product.id}"><h5 class="card-title">${product.name}</h5></a>
                                    <p class="card-text">${product.description}</p>
                                    <a href="javascript:void(0);" onclick="ajaxAddToCart(${product.getId()});"
                                       class="btn btn-primary">Купить</a>
                                </div>
                                <div class="card-footer">
                                    <h4 class="text-info">${product.price} Р</h4>
                                </div>
                            </div>
                            <#if ((product?counter-1)%4)==3||product?is_last>
                                </div>
                            </#if>
                        </#list>
                </div>
            </div>
        </div>
    </div>
</div>
    <@c.footer/>
</@c.page>




